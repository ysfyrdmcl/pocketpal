import React from "react";
import Chart from "react-apexcharts";

export default function PocketChart() {
  const seriesData = [
    {
      name: "pocket",
      data: [6000, 4500, 4000, 4200, 5000, 5000, 4800, 4000]
    },
  ];

  const optionsData = {
    chart: {
      type: "area",
    },
    dataLabels: {
      enabled: false,
    },
    stroke: {
      curve: "smooth",
    },
    xaxis: {
      type: "monthday",
      categories: ["9-1", "9-5", "9-10", "9-14", "9-19", "9-20", "9-24", "9-28", "9-30"],
    },
    tooltip: {
      x: {
        format: "dd/MM/yy",
      },
    },
  };

  return (
    <div className="app">
      <div className="row">
        <div id="chart">
          <Chart
            options={optionsData}
            series={seriesData}
            type="area"
            height={350}
            width={500}
          />
        </div>
      </div>
    </div>
  );
}


