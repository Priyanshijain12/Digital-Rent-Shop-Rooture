import React, { useEffect, useState } from "react";
import axios from "axios";
import ReportCard from "./ReportCard";

interface Report {
  title: string;
  value: string;
}

const ReportsPage: React.FC = () => {
  const [reports, setReports] = useState<Report[]>([]);

  useEffect(() => {
    axios.get("/api/reports/users")
      .then((res) => setReports(res.data))
      .catch(console.error);
  }, []);

  return (
    <div className="grid grid-cols-2 gap-4 p-6">
      {reports.map((r, i) => (
        <ReportCard key={i} title={r.title} value={r.value} />
      ))}
    </div>
  );
};

export default ReportsPage;
