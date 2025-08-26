export default function Footer() {
  const currentYear = new Date().getFullYear();

  return (
    <footer>
      <p>{currentYear} Eduardo Reinert</p>
    </footer>
  );
}
