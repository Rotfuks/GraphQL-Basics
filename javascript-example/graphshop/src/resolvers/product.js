export default {
  Query: {
    products: (parent, {id, search}, {models}) => {
      if (id) {
        return models.productdata.filter(
          (p) => p.id == id
        );
      }
      if (search) {
        return models.productdata.filter(
          (p) => p.name.includes(search)
        );
      } else {
        return models.productdata;
      }
    },
  },
  Mutation: {
    createProduct: (parent, {name}, {models, uuid}) => {
      let newProduct = {name: name, id: uuid()};
      models.productdata.push(newProduct);
      return newProduct;
    },
    deleteProduct: (parent, {id}, {models}) => {
      const newProducts =
        models.productdata.filter((p) => p.id != id);

      models.wishlistdata.forEach((w) => {
        w.products = w.products.filter((p) =>
          p.id != id
        )});

      models.productdata = newProducts;
      return true;
    },
  }
};