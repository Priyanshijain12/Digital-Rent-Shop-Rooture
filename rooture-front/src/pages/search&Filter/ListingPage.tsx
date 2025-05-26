import { useState } from 'react';
import { ListingSearch } from './ListingSearch';
import { ListingFilter } from './ListingFilter';
import { ListingResults } from './ListingResults';

const ListingPage = () => {
  const [results, setResults] = useState([]);
  return (
    <div>
      <h2>Search & Filter Listings</h2>
      <ListingSearch setResults={setResults} />
      <ListingFilter setResults={setResults} />
      <ListingResults results={results} />
    </div>
  );
};

export default ListingPage;
