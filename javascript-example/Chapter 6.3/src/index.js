const {ApolloServer, gql} = require('apollo-server');

const schema = gql`
    type Query {
        products(search: String): [Product!]
        customer(id: ID!): Customer
    }
    interface Node {
        id: ID!
    }
    type Product implements Node {
        id: ID!
        name: String!
    }
    type Customer implements Node {
        id: ID!
        fullname: String!
        wishlists: [Wishlist]
    }
    type Wishlist implements Node {
        id: ID!
        title: String
        products: [Product]!
    }
`;

let productdata = [{
  id: "2",
  name: 'Kartoffeln',
}, {
  id: "3",
  name: 'Pasta',
},];

let customerdata = [{
  id: "1",
  firstname: "Luke",
  lastname: "Skywalker",
  wishlistIds: ["10", "11"],
}];

let wishlistdata = [{
  id: "10",
  title: "Daily Needs",
  products: productdata,
}, {
  id: "11",
  title: "That one Recipe",
  products: [],
}];

const resolvers = {
  Query: {
    customer: (parent, {id}) => {
      return customerdata.find(
        (c) => c.id == id
      );
    },
    products: (parent, {id, search}) => {
      if (id) {
        return productdata.filter(
          (p) => p.id == id
        );
      }
      if (search) {
        return productdata.filter(
          (p) => p.name.includes(search)
        );
      }
      return productdata;
    }
  },
  Customer: {
    fullname: (customer) =>
      `${customer.firstname} ${customer.lastname}`,
    wishlists: customer => wishlistdata.filter(
      (w) => customer.wishlistIds.includes(w.id)),
  },
  Node: {
    __resolveType(node) {
      if (node.name) {
        return 'Product';
      }
      if (node.fullname) {
        return 'Customer';
      }
      if (node.title) {
        return 'Wishlist';
      }
    }
  }
};


const server = new ApolloServer({
  typeDefs: schema,
  resolvers,
});

// The `listen` method launches a web server.
server.listen().then(({url}) => {
  console.log(`Server ready at ${url}`);
});