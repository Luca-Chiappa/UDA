const ctx = document.getElementById('graficoProduzione');
if (ctx) {
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00"],
            datasets: [{
                label: 'Produzione Solare (kW)',
                data: [0.3, 0.6, 0.9, 1.2, 1.1, 0.8, 0.4],
                borderColor: '#2ecc71',
                backgroundColor: 'rgba(46, 204, 113, 0.15)',
                tension: 0.35,
                fill: true
            }]
        },
        options: {
            plugins: {
                legend: { labels: { color: '#eaeaea' } }
            },
            scales: {
                x: { ticks: { color: '#eaeaea' } },
                y: { ticks: { color: '#eaeaea' } }
            }
        }
    });
}
