import MainLayout from "./MainLayout";

function HomePage() {
  return (
    <MainLayout>
      <section className="relative">
        <div className="z-10">
          <div className="mx-auto max-w-5xl px-6 md:px-2 py-10 md:py-24 flex flex-col gap-6 items-center">
            <h1 className="text-4xl font-bold text-center max-w-[600px]">
              Welcome to BillionPixes!
            </h1>
            <p className="text-gray-600 text-base md:text-lg text-center max-w-[600px]">
              The way of surfing through street arts around the world.
            </p>
            <div className="flex gap-4 items-center text-center">
              <a
                href=""
                className="text-sm md:text-base bg-orange-500 border border-orange-500 rounded text-white font-bold py-2 px-6 hover:bg-orange-600"
              >
                Get started - it's free
              </a>
            </div>
          </div>
        </div>
      </section>
    </MainLayout>
  );
}

export default HomePage;
