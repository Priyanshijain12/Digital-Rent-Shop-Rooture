import React, { useState } from "react";
import { checkAccess } from '../../api/securityApi';

const AccessCheck: React.FC = () => {
  const [token, setToken] = useState("");
  const [role, setRole] = useState("");
  const [hasAccess, setHasAccess] = useState<boolean | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleCheck = async () => {
    try {
      const access = await checkAccess(token, role);
      setHasAccess(access);
      setError(null);
    } catch {
      setError("Failed to check access");
      setHasAccess(null);
    }
  };

  return (
    <div>
      <h2>Check Access</h2>
      <input
        type="text"
        placeholder="Token"
        value={token}
        onChange={e => setToken(e.target.value)}
      /><br/>
      <input
        type="text"
        placeholder="Role"
        value={role}
        onChange={e => setRole(e.target.value)}
      /><br/>
      <button onClick={handleCheck}>Check Access</button>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {hasAccess !== null && (
        <p>{hasAccess ? "Access Granted" : "Access Denied"}</p>
      )}
    </div>
  );
};

export default AccessCheck;
