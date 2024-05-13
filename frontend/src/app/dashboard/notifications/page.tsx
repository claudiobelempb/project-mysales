'use client';

import { HeaderRoot } from '@/components/HeaderRoot';

// export const metadata: Metadata = {
//   title: 'Página Notifications',
//   description: 'Estamos construindo um template admin!'
// };

export default function Notifications() {
  return (
    <div
      className={`
      h-screen
      
    `}
    >
      <HeaderRoot
        title='Página Notifications'
        subTitle='Aqui voçê irá gerenciar as suas notificações!'
      />
      <div className='mt-7'>
        <h1 onClick={() => alert(99)}>Notifications</h1>
      </div>
    </div>
  );
}
