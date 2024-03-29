'use client';

import { Header } from '@/components/header';

// export const metadata: Metadata = {
//   title: 'Página Settings',
//   description: 'Estamos construindo um template admin!'
// };

export default function Settings() {
  return (
    <div
      className={`
      h-screen
      
    `}
    >
      <Header
        title='Página Ajustes & Configurações'
        subTitle='Pesonalize o sistema por aqui!'
      />
      <div className='mt-7'>
        <h1>Settings</h1>
      </div>
    </div>
  );
}
