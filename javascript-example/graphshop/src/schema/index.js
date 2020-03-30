import { gql } from 'apollo-server-express';

import customerSchema from './customer'
import wishlistSchema from './wishlist'
import productSchema from './product'

const linkSchema = gql`
  type Query {
    _: Boolean
  }
  interface Node {
    id: ID!
  }
  type Mutation {
    _: Boolean
  }
`;
export default [linkSchema, customerSchema,
  wishlistSchema, productSchema];