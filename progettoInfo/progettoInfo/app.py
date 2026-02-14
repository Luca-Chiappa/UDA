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
    energia = [
        {"id": 1, "classeEnergetica": "A++", "consumoOrario": 0.8},
        {"id": 2, "classeEnergetica": "A+", "consumoOrario": 1.2},
        {"id": 3, "classeEnergetica": "B", "consumoOrario": 1.8},
    ]
    return render_template("dispositivi.html", title="Elettrodomestici", energia=energia)

@app.route("/simulazione")
def simulazione():
    return render_template("simulazione.html", title="Simulazione")

@app.route("/report")
def report():
    return render_template("report.html", title="Report")

@app.route("/tabella")
def tabella():
    return render_template("tabella.html", title="Tabella Dinamica")

@app.route("/api/simula", methods=["POST"])
def simula():
    dati = request.json
    ore = int(dati.get("oreUso", 2))

    timeline = []
    produzione_base = 0.5
    consumo_base = 0.3

    for i in range(ore):
        ora = f"{8 + i:02d}:00"
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
