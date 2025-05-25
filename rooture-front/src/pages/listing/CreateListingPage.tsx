import React, { useEffect, useState } from "react";

interface Listing {
  id: number;
  title: string;
  description: string;
  type: string;
  price: number;
  available: boolean;
}

const CreateListingPage: React.FC = () => {
  const [form, setForm] = useState<Omit<Listing, "id">>({
    title: "",
    description: "",
    type: "Room",
    price: 0,
    available: true,
  });
  const [listings, setListings] = useState<Listing[]>([]);
  const [editId, setEditId] = useState<number | null>(null);

  const fetchListings = async () => {
    const res = await fetch("/api/listings");
    const data = await res.json();
    setListings(data);
  };

  useEffect(() => {
    fetchListings();
  }, []);

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setForm({
      ...form,
      [name]: name === "price" ? parseFloat(value) : value,
    });
  };

  const handleSubmit = async () => {
    if (editId !== null) {
      await fetch(`/api/listings/${editId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });
      setEditId(null);
    } else {
      await fetch("/api/listings", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });
    }
    setForm({
      title: "",
      description: "",
      type: "Room",
      price: 0,
      available: true,
    });
    fetchListings();
  };

  const handleDelete = async (id: number) => {
    await fetch(`/api/listings/${id}`, {
      method: "DELETE",
    });
    fetchListings();
  };

  const handleEdit = (listing: Listing) => {
    setForm({
      title: listing.title,
      description: listing.description,
      type: listing.type,
      price: listing.price,
      available: listing.available,
    });
    setEditId(listing.id);
  };

  return (
    <div className="p-4">
      <h2 className="text-xl mb-2">
        {editId ? "Update Listing" : "Create Listing"}
      </h2>
      <input
        name="title"
        value={form.title}
        onChange={handleChange}
        placeholder="Title"
        className="block mb-2 border p-2"
      />
      <input
        name="description"
        value={form.description}
        onChange={handleChange}
        placeholder="Description"
        className="block mb-2 border p-2"
      />
      <select
        name="type"
        value={form.type}
        onChange={handleChange}
        className="block mb-2 border p-2"
      >
        <option value="Room">Room</option>
        <option value="Furniture">Furniture</option>
      </select>
      <input
        name="price"
        type="number"
        value={form.price}
        onChange={handleChange}
        placeholder="Price"
        className="block mb-2 border p-2"
      />
      <button
        onClick={handleSubmit}
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        {editId ? "Update" : "Create"}
      </button>

      <h3 className="mt-6 text-lg">All Listings</h3>
      <div className="mt-2 space-y-4">
        {listings.map((listing) => (
          <div
            key={listing.id}
            className="border p-4 rounded shadow flex justify-between items-center"
          >
            <div>
              <h4 className="font-semibold">{listing.title}</h4>
              <p>{listing.description}</p>
              <p>Type: {listing.type}</p>
              <p>Price: ₹{listing.price}</p>
              <p>Status: {listing.available ? "Available" : "Unavailable"}</p>
            </div>
            <div className="flex gap-2">
              <button
                onClick={() => handleEdit(listing)}
                className="bg-yellow-500 text-white px-2 py-1 rounded"
              >
                Edit
              </button>
              <button
                onClick={() => handleDelete(listing.id)}
                className="bg-red-500 text-white px-2 py-1 rounded"
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CreateListingPage;
