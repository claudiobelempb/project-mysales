import { HeaderRoot } from '@/components/HeaderRoot';

export default function Page() {
  return (
    <div>
      <HeaderRoot
        title='Página Inicial'
        subTitle='Estamos construindo um template admin!'
      />
      <div className='mt-7'>
        <h1>Hello, Dashboard Page!</h1>
      </div>
    </div>
  );
}
