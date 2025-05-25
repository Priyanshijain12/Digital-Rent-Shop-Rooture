import React from "react";

export interface Listing {
  id: number;
  title: string;
  description: string;
  type: string;
  price: number;
  available: boolean;
}

const ListingCard: React.FC<{ listing: Listing }> = ({ listing }) => {
  return (
    <div className="border p-4 rounded shadow">
      <h2>{listing.title}</h2>
      <p>{listing.description}</p>
      <p>Type: {listing.type}</p>
      <p>Price: ₹{listing.price}</p>
      <p>Status: {listing.available ? "Available" : "Not Available"}</p>
    </div>
  );
};

export default ListingCard;
