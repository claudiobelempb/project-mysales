// 'use server';

import {
  Bell,
  Home,
  LogOut,
  PackageSearch,
  Settings,
  Users
} from 'lucide-react';
import { SidebarItem } from './SidebarItem';

export default function Sidebar() {
  return (
    <aside className='flex flex-col h-auto bg-white text-gray-800'>
      <div className='flex flex-col justify-center items-center h-20 w-20 bg-gradient-to-r from-indigo-500 to-purple-800'>
        <span className='text-center text-white'>Logo</span>
      </div>
      <ul className='flex flex-col gap-3'>
        <SidebarItem url='/dashboard' text='Home' icone={<Home />} />
        {/*<SidebarItem url='/dashboard/users' text='Usuários' icone={<Users />} />*/}
        <SidebarItem
          url='/dashboard/clients'
          text='Clientes'
          icone={<Users />}
        />
        <SidebarItem
          url='/dashboard/products'
          text='Produtos'
          icone={<PackageSearch />}
        />
        <SidebarItem
          url='/dashboard/notifications'
          text='Notifications'
          icone={<Bell />}
        />
        <SidebarItem
          url='/dashboard/settings'
          text='Settings'
          icone={<Settings />}
        />
      </ul>
      <button
        // onClick={() => alert(77)}
        type='button'
        className='flex flex-col gap-1 items-center justify-center w-20 h-20 mt-auto text-sm hover:bg-gray-100'
      >
        <LogOut />
        <span className='text-xs font-light text-gray-600'>Sair</span>
      </button>
    </aside>
  );
}
