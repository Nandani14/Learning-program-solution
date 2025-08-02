function BookDetails() {
  const book = { title: "Atomic Habits", author: "James Clear", price: 450 };
  if (book.price < 500) {
    return <p>{book.title} by {book.author} - ₹{book.price}</p>;
  }
  return null;
}

function BlogDetails() {
  const published = true;
  return (
    <div>
      {published ? <p>Blog is published!</p> : <p>Blog is draft</p>}
    </div>
  );
}

function CourseDetails() {
  const show = true;
  return (
    <>
      {show && <p>ReactJS Full Course Available</p>}
    </>
  );
}

function App() {
  return (
    <div>
      <BookDetails />
      <BlogDetails />
      <CourseDetails />
    </div>
  );
}

export default App;
