export interface LoginRequest {
  username: string;
  password: string;
}

export interface LoginResponse {
  token: string;
  role: string;
}

export async function loginUser(data: LoginRequest): Promise<LoginResponse> {
  const response = await fetch("/api/security/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!response.ok) {
    throw new Error("Login failed");
  }
  return response.json();
}

export async function checkAccess(token: string, role: string): Promise<boolean> {
  const response = await fetch(`/api/security/check-access?role=${role}`, {
    headers: { Authorization: token },
  });
  if (!response.ok) {
    throw new Error("Access check failed");
  }
  return response.json();
}
