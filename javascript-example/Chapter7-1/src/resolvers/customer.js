module.exports = {
  Query: {
    customer: (parent, {id}, {models}) => {
      return models.customerdata.find(
        (c) => c.id == id
      );},
  },
  Customer: {
    fullname: (customer) => `${customer.firstname} ${customer.lastname}`,
    wishlists: (customer, args, {models}) => models.wishlistdata.filter(
      (w) => customer.wishlistIds.includes(w.id)),
  },
};