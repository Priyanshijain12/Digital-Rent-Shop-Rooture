import React, { useEffect, useState } from 'react';

interface Listing {
  id: number;
  title: string;
  description?: string;
  owner?: string;
}

const ListingManagement = () => {
  const [listings, setListings] = useState<Listing[]>([]);

  useEffect(() => {
    fetch('/api/admin/listings')
      .then(res => res.json())
      .then(setListings);
  }, []);

  return (
    <div>
      <h2>Listing Management</h2>
      <ul>
        {listings.map(listing => (
          <li key={listing.id}>{listing.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListingManagement;
