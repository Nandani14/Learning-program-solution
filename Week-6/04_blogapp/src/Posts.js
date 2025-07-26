import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = { posts: [] };
  }

  async componentDidMount() {
    const res = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data = await res.json();
    this.setState({ posts: data });
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
  }

  render() {
    return (
      <div>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h4>{post.title}</h4>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
