import { gql } from 'apollo-server-express';

export default gql`
extend type Query {
  customer(id: ID!): Customer
}
type Customer implements Node{
  id: ID!
  fullname: String!
  wishlists: [Wishlist]
}
`;
