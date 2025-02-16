import React from "react";
import { gql, useQuery } from "@apollo/client";

const GET_ALL_USERS = gql`
  query {
    getAllUsers {
      id
      username
      email
    }
  }
`;

const UsersList = () => {
  const { loading, error, data } = useQuery(GET_ALL_USERS);

  if (loading) return <p>Loading users...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
    <div>
      <h2>Users List</h2>
      <ul>
        {data.getAllUsers.map((user) => (
          <li key={user.id}>
            <strong>{user.username}</strong> - {user.email}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UsersList;
