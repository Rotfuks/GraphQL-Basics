export default {
  Mutation: {
    createWishlist: (parent, {wishlistInput}, {models, uuid}) => {
      let products = [];
      wishlistInput.products.forEach((p) => {
        if(p.id){
          products.push(models.productdata.find(
            (pdata) => pdata.id == p.id
          ))
        } else if (p.name){
          let product = {id: uuid(), name: p.name};
          products.push(product);
          models.productdata.push(product)
        }});

      const wishlist = {
        id: uuid(),
        title: wishlistInput.title,
        products: products,
      };
      let customer = models.customerdata.find(
        (c) => c.id == wishlistInput.customerId);
      const index = models.customerdata.indexOf(customer);
      customer.wishlistIds.push(wishlist.id);
      models.wishlistdata.push(wishlist);
      models.customerdata[index] = customer;

      return wishlist;
    },
    deleteWishlist: (parent, {wishlistIds}, {models}) => {
      let customers = models.customerdata;
      customers.forEach((c) => {
        c.wishlistIds = c.wishlistIds.filter(
          (id) => !wishlistIds.includes(id)
        )});
      models.customerdata = customers;

      models.wishlistdata = models.wishlistdata.filter(
        (w) => !wishlistIds.includes(w.id)
      );
      return true;
    }
  },
};