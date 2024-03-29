'use client';

import { Header } from '@/components/header';

// export const metadata: Metadata = {
//   title: 'Página Settings',
//   description: 'Estamos construindo um template admin!'
// };

export default function Users() {
  return (
    <div
      className={`
      h-screen
      
    `}
    >
      <Header
        title='Página Usuários'
        subTitle='Aqui voçê irá gerenciar seus Usuários!'
      />
      <div className='mt-7'>
        <h1>Usuários</h1>
      </div>
    </div>
  );
}
