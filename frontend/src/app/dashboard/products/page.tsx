'use client';

import { Header } from '@/components/header';
import { Edit, Plus } from 'lucide-react';
import Link from 'next/link';

export default function Products() {
  return (
    <div
      className={`
      h-screen
      
    `}
    >
      <Header
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />
      <div className='w-full flex items-center py-4 gap-2'>
        <Link
          className='bg-green-500 p-1 rounded-sm text-white'
          href='/dashboard/products/create'
        >
          <Plus />
        </Link>
        <Link
          className='bg-gray-500 p-1 rounded-sm text-white'
          href={`/dashboard/products/update/1`}
        >
          <Edit />
        </Link>
      </div>
      <div className='mt-7'>
        <h1>Lista de Produtos</h1>
        <div className='flex flex-col gap-2 mt-7'>list</div>
      </div>
    </div>
  );
}
