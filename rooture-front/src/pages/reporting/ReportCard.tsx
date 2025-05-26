import React from "react";

interface ReportCardProps {
  title: string;
  value: string;
}

const ReportCard: React.FC<ReportCardProps> = ({ title, value }) => (
  <div className="border rounded-xl shadow-md p-4">
    <h2 className="text-lg font-bold">{title}</h2>
    <p className="text-2xl text-blue-600">{value}</p>
  </div>
);

export default ReportCard;
