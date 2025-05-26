import React, { useState } from 'react';
import axios from 'axios';

const SupportForm: React.FC = () => {
    const [subject, setSubject] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async () => {
        const query = { userId: '1', subject, description };
        await axios.post('/api/support/contact', query);
    };

    return (
        <div>
            <h2>Contact Support</h2>
            <input value={subject} onChange={e => setSubject(e.target.value)} placeholder="Subject" />
            <textarea value={description} onChange={e => setDescription(e.target.value)} placeholder="Description" />
            <button onClick={handleSubmit}>Submit</button>
        </div>
    );
};

export default SupportForm;