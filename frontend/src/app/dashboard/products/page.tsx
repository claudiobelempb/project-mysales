'use client';

import { LoadingRoot, LoadingSvg } from '@/components/LoadingRoot';
import { Header } from '@/components/header';
import { ProductResponse } from '@/http/response/ProductResponse';
import { ProductDeleteService } from '@/services/product/ProductDeleteService';
import { ProductFindAllService } from '@/services/product/ProductFindAllService';
import { FORMAR_REAL_V1 } from '@/utils/format/money';
import { Edit, Plus, Trash2 } from 'lucide-react';
import Link from 'next/link';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

export default function Products() {
  const [content, setContent] = useState<ProductResponse[]>([]);
  const [loading, setLoading] = useState(true);

  const handleDelete = async (id: number) => {
    try {
      await ProductDeleteService(id);

      toast.success('Produto deletado com sucesso!');
      const listProducts: ProductResponse[] = content.filter(p => p.id !== id);
      setContent(listProducts);
    } catch (error) {
      console.log(JSON.parse(JSON.stringify(error)));
    }
  };

  useEffect(() => {
    (async function loadingProduct() {
      try {
        const response = await ProductFindAllService();
        setContent(response.content);
      } catch (error) {
        console.log(error);
      } finally {
        setLoading(false);
      }
    })();
  }, []);

  return loading ? (
    <LoadingRoot>
      <LoadingSvg className='text-gray-500 w-12 h-12' />
    </LoadingRoot>
  ) : (
    <div
      className={`
        min-h-screen
        
      `}
    >
      <Header
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />
      <div className='w-full flex items-center py-4 gap-2'>
        <Link
          className='bg-green-500 p-1 rounded-sm text-white hover:bg-green-400 transition-all duration-150'
          href='/dashboard/products/create'
        >
          <Plus />
        </Link>
      </div>
      <div className='mt-7'>
        <h1>Lista de Produtos</h1>
        <div className='flex flex-col gap-2 mt-7'>
          <div className='relative overflow-x-auto shadow-md sm:rounded-lg'>
            <table className='w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400'>
              <thead className='text-xs text-gray-700 uppercase bg-gray-100 dark:bg-gray-700 dark:text-gray-400'>
                <tr>
                  <th scope='col' className='px-6 py-3'>
                    Código
                  </th>
                  <th scope='col' className='px-6 py-3'>
                    SKU
                  </th>
                  <th scope='col' className='px-6 py-3'>
                    Nome
                  </th>
                  <th scope='col' className='px-6 py-3'>
                    Price
                  </th>
                  <th scope='col' className='px-6 py-3'>
                    <span>Ações</span>
                  </th>
                </tr>
              </thead>
              <tbody>
                {content?.map(product => (
                  <tr
                    key={product.id}
                    className='bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600'
                  >
                    <td className='px-6 py-4'>{product.id}</td>
                    <td className='px-6 py-4'>{product.sku}</td>
                    <td className='px-6 py-4'>{product.name}</td>
                    <td className='px-6 py-4'>
                      {FORMAR_REAL_V1(product.price || 0.0)}
                    </td>
                    <td className='px-6 py-4 flex items-center gap-2'>
                      <Link
                        className='rounded-sm bg-yellow-500 text-white p-1 hover:bg-yellow-400 transition-all duration-150'
                        href={`/dashboard/products/update/${product.id}`}
                      >
                        <Edit />
                      </Link>
                      <button
                        onClick={() => handleDelete(product.id)}
                        className=' rounded-sm bg-red-500 text-white p-1 hover:bg-red-400 transition-all duration-150'
                      >
                        <Trash2 />
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}
