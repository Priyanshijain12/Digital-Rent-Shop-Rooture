import React, { useState } from "react";
import { loginUser, LoginResponse } from '../../api/securityApi';

const LoginPage: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string | null>(null);
  const [loginResponse, setLoginResponse] = useState<LoginResponse | null>(null);

  const handleLogin = async () => {
    try {
      const response = await loginUser({ username, password });
      setLoginResponse(response);
      setError(null);
    } catch {
      setError("Invalid credentials");
      setLoginResponse(null);
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={e => setUsername(e.target.value)}
      /><br/>
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={e => setPassword(e.target.value)}
      /><br/>
      <button onClick={handleLogin}>Login</button>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {loginResponse && (
        <div>
          <p>Logged in as {loginResponse.role}</p>
          <p>Token: {loginResponse.token}</p>
        </div>
      )}
    </div>
  );
};

export default LoginPage;
