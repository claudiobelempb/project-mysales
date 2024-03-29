import { Header } from '@/components/header';

export default function Page() {
  return (
    <div>
      <Header
        title='Página Inicial'
        subTitle='Estamos construindo um template admin!'
      />
      <div className='mt-7'>
        <h1>Hello, Dashboard Page!</h1>
      </div>
    </div>
  );
}
