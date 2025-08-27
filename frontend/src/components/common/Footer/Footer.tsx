export default function Footer() {
  const currentYear = new Date().getFullYear();

  return (
    <footer>
      <div className="px-2 py-20 mx-auto max-w-7xl">
        <div className="pt-12 border-t border-gray-300 flex flex-col md:flex-row gap-10 items-center">
          <div className="text-black flex flex-col">
            <a href="/" className="font-bold text-xl mx-auto md:mx-0">
              <span className="text-orange-500">
                <i className="bi bi-bookmark-fill"></i> Billion
              </span>
              Pixes
            </a>
            <p className="mt-2 text-sm text-gray-500 lg:w-4/5">
              The street art is alive. Help documenting it before it is too
              late.
            </p>
          </div>
        </div>
        <div className="flex flex-col pt-12 md:flex-row md:items-center md:justify-between">
          <p className="text-center md:text-left">
            <span className="mx-auto mt-2 text-sm text-gray-500 lg:mx-0">
              © Eduardo Reinert {currentYear}
            </span>
          </p>
        </div>
      </div>
    </footer>
  );
}
