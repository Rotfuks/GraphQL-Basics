const { gql } = require('apollo-server');

module.exports = gql`
type Wishlist implements Node {
  id: ID!
  title: String
  products: [Product]!
}
input CreateWishlistInput {
  customerId: ID!
  title: String
  products: [ProductInput]!
}
extend type Mutation {
  createWishlist(wishlistInput: CreateWishlistInput!): Wishlist
  deleteWishlist(wishlistIds: [ID]!): Boolean
}
`;
