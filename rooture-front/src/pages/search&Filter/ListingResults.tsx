export const ListingResults = ({ results }: any) => (
  <div>
    {results.map((listing: any) => (
      <div key={listing.id}>
        <p>{listing.location} - {listing.type} - ₹{listing.price} - {listing.available ? 'Available' : 'Unavailable'}</p>
      </div>
    ))}
  </div>
);
