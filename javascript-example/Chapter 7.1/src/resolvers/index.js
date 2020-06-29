const customerResolver = require('./customer');
const productResolver = require('./product');

const nodeResolver = {
  Node: {
    __resolveType(node) {
      if (node.name) {
        return 'Product';
      } if(node.fullname) {
        return 'Customer';
      } if(node.title) {
        return 'Wishlist';
      }}}};

module.exports = [nodeResolver, customerResolver,
  productResolver];