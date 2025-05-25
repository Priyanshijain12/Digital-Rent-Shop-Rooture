const RoleAssignPage = () => {
  const assignRole = async () => {
    await fetch('/api/users/role', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username: 'john', role: 'Admin' }),
    });
  };
  return <button onClick={assignRole}>Assign Role</button>;
};
