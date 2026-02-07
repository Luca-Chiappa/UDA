from flask import Flask, render_template, request, jsonify
import requests

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


@app.route('/api/elettrodomestici')
def api_elettrodomestici():
    """Proxy verso il backend Spring Boot che espone /elettrodomestici su http://localhost:8080

    Questo permette alla UI Flask di fare fetch in same-origin senza problemi di CORS.
    """
    try:
        resp = requests.get('http://localhost:8080/elettrodomestici', timeout=5)
        resp.raise_for_status()
        return jsonify(resp.json())
    except requests.exceptions.RequestException as e:
        return jsonify({'error': str(e)}), 502

@app.route("/report")
def report():
    return render_template("report.html", title="Report")

@app.route("/api/simula", methods=["POST"])
def simula():
    dati = request.json
    ore = int(dati.get("oreUso", 2))
    timeline = [
        {"ora": "08:00", "produzione": 0.5, "consumo": 0.3, "surplus": 0.2},
        {"ora": "09:00", "produzione": 0.8, "consumo": 0.4, "surplus": 0.4},
        {"ora": "10:00", "produzione": 1.2, "consumo": 0.6, "surplus": 0.6},
    ]
    return jsonify({"oreUso": ore, "timeline": timeline})

if __name__ == "__main__":
    app.run(debug=True)
