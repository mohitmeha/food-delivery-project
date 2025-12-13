const API_BASE = 'http://localhost:9090/api';

const api = {
  async getRestaurants() {
    const res = await fetch(`${API_BASE}/restaurants/list`);
    if (!res.ok) throw new Error('Failed to fetch restaurants');
    return await res.json();
  },

  async getRestaurant(id) {
    const res = await fetch(`${API_BASE}/restaurants/${id}`);
    if (!res.ok) throw new Error('Failed to fetch restaurant');
    return await res.json();
  },

  async placeOrder(order) {
    const res = await fetch(`${API_BASE}/orders`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(order)
    });
    if (!res.ok) throw new Error('Failed to place order');
    return await res.json();
  }
};
