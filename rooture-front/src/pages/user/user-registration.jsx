import React, { useState } from 'react';
import axios from 'axios';

function UserRegistration() {
const [formData, setFormData] = useState({
username: '',
password: '',
email: '',
phone: '',
role: 'User',
});

const handleChange = (e) => {
setFormData(prev => ({
...prev,
[e.target.name]: e.target.value
}));
};

const handleSubmit = async (e) => {
e.preventDefault();
try {
const res = await axios.post('http://localhost:8080/api/users/register', formData);
alert(res.data);
} catch (err) {
console.error(err);
alert("Error occurred during registration.");
}
};

return (
<div style={{ maxWidth: "400px", margin: "auto" }}>
<h2>User Registration</h2>
<form onSubmit={handleSubmit}>
<input type="text" name="username" placeholder="Username" required onChange={handleChange} /><br />
<input type="password" name="password" placeholder="Password" required onChange={handleChange} /><br />
<input type="email" name="email" placeholder="Email" required onChange={handleChange} /><br />
<input type="tel" name="phone" placeholder="Phone" required onChange={handleChange} /><br />
<select name="role" value={formData.role} onChange={handleChange}>
<option>User</option>
<option>Admin</option>
<option>Owner</option>
</select><br /><br />
<button type="submit">Register</button>
</form>
</div>
);
}

export default UserRegistration;