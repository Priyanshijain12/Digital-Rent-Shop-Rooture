import { useState } from 'react';
import axios from 'axios';

export const ListingFilter = ({ setResults }: any) => {
  const [type, setType] = useState('');
  const [minPrice, setMinPrice] = useState('');
  const [maxPrice, setMaxPrice] = useState('');
  const [available, setAvailable] = useState(false);

  const handleFilter = async () => {
    const { data } = await axios.get('/api/listings/filter', {
      params: { type, minPrice, maxPrice, available }
    });
    setResults(data);
  };

  return (
    <div>
      <input placeholder="Type" value={type} onChange={e => setType(e.target.value)} />
      <input placeholder="Min Price" value={minPrice} onChange={e => setMinPrice(e.target.value)} />
      <input placeholder="Max Price" value={maxPrice} onChange={e => setMaxPrice(e.target.value)} />
      <label>
        Available
        <input type="checkbox" checked={available} onChange={e => setAvailable(e.target.checked)} />
      </label>
      <button onClick={handleFilter}>Filter</button>
    </div>
  );
};
