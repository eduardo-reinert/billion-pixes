import MainLayout from "./MainLayout";

function HomePage() {
  return (
    <MainLayout>
      <div className="" id="main-body">
        <h1 className="text-9x1 font-bold underline">
          Welcome to BillionPixes!
        </h1>
        <h2>The way of surfing through street arts around the world.</h2>
        <p className="bg-amber-50">
          The word "pichação" in portuguese is the act of writing or mumbling in
          walls, edifications front, street asphalts or monuments, with any type
          of material
        </p>
      </div>
    </MainLayout>
  );
}

export default HomePage;
