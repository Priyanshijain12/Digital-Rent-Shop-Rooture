const RegisterPage = () => {
  const handleRegister = async (e: any) => {
    e.preventDefault();
    await fetch('/api/users/register', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username: 'john', email: 'j@x.com', phone: '1234567890', password: 'abc123' }),
    });
  };
  return <button onClick={handleRegister}>Register</button>;
};