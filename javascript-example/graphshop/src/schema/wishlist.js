import { gql } from 'apollo-server-express';

export default gql`
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
