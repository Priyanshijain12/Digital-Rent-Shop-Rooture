import React, { useState } from 'react';
import axios from 'axios';

const FeedbackForm: React.FC = () => {
    const [message, setMessage] = useState('');

    const handleSubmit = async () => {
        const feedback = { userId: '1', listingId: '123', message };
        await axios.post('/api/feedback/submit', feedback);
    };

    return (
        <div>
            <h2>Submit Feedback</h2>
            <textarea value={message} onChange={e => setMessage(e.target.value)} />
            <button onClick={handleSubmit}>Submit</button>
        </div>
    );
};

export default FeedbackForm;