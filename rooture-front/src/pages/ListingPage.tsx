import React, { useEffect, useState } from "react";
import ListingCard, { Listing } from "../components/ListingCard";

const ListingsPage: React.FC = () => {
  const [listings, setListings] = useState<Listing[]>([]);

  useEffect(() => {
    fetch("/api/listings")
      .then((res) => res.json())
      .then((data) => setListings(data));
  }, []);

  return (
    <div className="grid gap-4 p-4">
      {listings.map((listing) => (
        <ListingCard key={listing.id} listing={listing} />
      ))}
    </div>
  );
};

export default ListingsPage;
