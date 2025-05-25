const LoginPage = () => {
  const handleLogin = async () => {
    await fetch('/api/users/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username: 'john', password: 'abc123' }),
    });
  };
  return <button onClick={handleLogin}>Login</button>;
};