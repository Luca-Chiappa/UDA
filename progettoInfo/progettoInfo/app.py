from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

@app.route("/")
def dashboard():
    produzione_totale = 12.5
    consumo_totale = 9.3
    surplus = produzione_totale - consumo_totale
    return render_template(
        "dashboard.html",
        title="Dashboard",
        produzione_totale=produzione_totale,
        consumo_totale=consumo_totale,
        surplus=surplus
    )

@app.route("/dispositivi")
def dispositivi():
    # the page is initially rendered empty; the client-side JS will fetch data
    return render_template("dispositivi.html", title="Elettrodomestici")

@app.route("/simulazione")
def simulazione():
    return render_template("simulazione.html", title="Simulazione")

@app.route("/report")
def report():
    return render_template("report.html", title="Report")

@app.route("/tabella")
def tabella():
    return render_template("tabella.html", title="Tabella Dinamica")

# ---------------------------------------------
# helper to proxy requests to Spring Boot backend
# ---------------------------------------------
SPRING_BASE = "http://localhost:8080"  # adjust if your Spring server runs on another host/port


def spring_get(path, **kwargs):
    return requests.get(SPRING_BASE + path, **kwargs)

def spring_post(path, json=None, **kwargs):
    return requests.post(SPRING_BASE + path, json=json, **kwargs)

def spring_delete(path, **kwargs):
    return requests.delete(SPRING_BASE + path, **kwargs)

# elettrodomestici endpoints ------------------------------------------------
@app.route("/api/elettrodomestici")
def api_get_elettrodomestici():
    resp = spring_get("/elettrodomestici")
    return jsonify(resp.json()), resp.status_code

@app.route("/api/elettrodomestici/<int:obj_id>")
def api_get_elettrodomestico(obj_id):
    resp = spring_get(f"/elettrodomestici/{obj_id}")
    return jsonify(resp.json()), resp.status_code

@app.route("/api/elettrodomestici", methods=["POST"])
def api_create_elettrodomestico():
    resp = spring_post("/elettrodomestici", json=request.json)
    return jsonify(resp.json()), resp.status_code

@app.route("/api/elettrodomestici/<int:obj_id>", methods=["DELETE"])
def api_delete_elettrodomestico(obj_id):
    resp = spring_delete(f"/elettrodomestici/{obj_id}")
    return ("", resp.status_code)

# Energia proxies -----------------------------------------------------------
@app.route("/api/energia")
def api_get_energia():
    resp = spring_get("/energia")
    return jsonify(resp.json()), resp.status_code

@app.route("/api/energia/<int:obj_id>")
def api_get_energia_single(obj_id):
    resp = spring_get(f"/energia/{obj_id}")
    return jsonify(resp.json()), resp.status_code

@app.route("/api/energia", methods=["POST"])
def api_create_energia():
    resp = spring_post("/energia", json=request.json)
    return jsonify(resp.json()), resp.status_code

@app.route("/api/energia/<int:obj_id>", methods=["DELETE"])
def api_delete_energia(obj_id):
    resp = spring_delete(f"/energia/{obj_id}")
    return ("", resp.status_code)

# keep the original dummy simulation route below (it can be removed if not needed)
@app.route("/api/simula", methods=["POST"])
def simula():
    dati = request.json
    ore = int(dati.get("oreUso", 2))
 
    timeline = []
    produzione_base = 0.5
    consumo_base = 0.3
 
    for i in range(ore):
        ora = f"{(8 + i) % 24:02d}:00"  
 
        produzione = round(produzione_base + i * 0.1, 2)
        consumo = round(consumo_base + i * 0.05, 2)
        surplus = round(produzione - consumo, 2)
 
        timeline.append({
            "ora": ora,
            "produzione": produzione,
            "consumo": consumo,
            "surplus": surplus
        })
 
    return jsonify({"oreUso": ore, "timeline": timeline})


if __name__ == "__main__":
    app.run(debug=True)
