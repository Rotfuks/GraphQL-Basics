import customerResolver from './customer';
import productResolver from './product';
import wishlistResolver from './wishlist';

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

export default [nodeResolver, customerResolver,
  productResolver, wishlistResolver];