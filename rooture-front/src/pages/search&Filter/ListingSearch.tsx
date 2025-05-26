import { useState } from 'react';
import axios from 'axios';

export const ListingSearch = ({ setResults }: any) => {
  const [location, setLocation] = useState('');
  const [type, setType] = useState('');
  const [price, setPrice] = useState('');

  const handleSearch = async () => {
    const { data } = await axios.get('/api/listings/search', {
      params: { location, type, price }
    });
    setResults(data);
  };

  return (
    <div>
      <input placeholder="Location" value={location} onChange={e => setLocation(e.target.value)} />
      <input placeholder="Type" value={type} onChange={e => setType(e.target.value)} />
      <input placeholder="Max Price" value={price} onChange={e => setPrice(e.target.value)} />
      <button onClick={handleSearch}>Search</button>
    </div>
  );
};
