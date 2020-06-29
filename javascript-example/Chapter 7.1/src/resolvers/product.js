module.exports = {
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
  }
};