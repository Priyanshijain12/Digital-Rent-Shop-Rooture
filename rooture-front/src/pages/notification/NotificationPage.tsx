import { useState } from 'react';

const NotificationPage = () => {
  const [email, setEmail] = useState("");
  const [subject, setSubject] = useState("");
  const [message, setMessage] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  const sendEmail = async () => {
    const res = await fetch('/api/notifications/send-email', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ to: email, subject, message })
    });
    alert(await res.text());
  };

  const sendSms = async () => {
    const res = await fetch('/api/notifications/send-sms', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ phoneNumber, message })
    });
    alert(await res.text());
  };

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">Send Notification</h2>
      <div className="mb-2">
        <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} className="border p-2 w-full" />
        <input type="text" placeholder="Subject" value={subject} onChange={e => setSubject(e.target.value)} className="border p-2 w-full mt-2" />
        <textarea placeholder="Message" value={message} onChange={e => setMessage(e.target.value)} className="border p-2 w-full mt-2" />
        <button onClick={sendEmail} className="bg-blue-500 text-white px-4 py-2 mt-2">Send Email</button>
      </div>
      <div className="mb-2 mt-6">
        <input type="text" placeholder="Phone Number" value={phoneNumber} onChange={e => setPhoneNumber(e.target.value)} className="border p-2 w-full" />
        <textarea placeholder="Message" value={message} onChange={e => setMessage(e.target.value)} className="border p-2 w-full mt-2" />
        <button onClick={sendSms} className="bg-green-500 text-white px-4 py-2 mt-2">Send SMS</button>
      </div>
    </div>
  );
};

export default NotificationPage;