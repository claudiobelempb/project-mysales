'use client';

import { HeaderRoot } from '@/components/HeaderRoot';
import { LoadingRoot, LoadingSvg } from '@/components/LoadingRoot';
import { TableActions, TableRoot } from '@/components/TableRoot';
import { ProductResponse } from '@/http/response/ProductResponse';
import { ProductDeleteService } from '@/services/product/ProductDeleteService';
import { ProductFindAllService } from '@/services/product/ProductFindAllService';
import { FORMAR_PRICE_V1 } from '@/utils/format/money';
import { Plus } from 'lucide-react';
import Link from 'next/link';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

export default function Products() {
  const [content, setContent] = useState<ProductResponse[]>([]);
  const [loading, setLoading] = useState(true);
  const [isDelete, setIsDelete] = useState(false);

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

  const handleConfirm = (id: number) => {
    console.log(id);
    if (isDelete) {
      handleDelete(id);
      setIsDelete(false);
    } else {
      setIsDelete(true);
    }
  };

  const handleCancel = () => setIsDelete(false);

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
      <HeaderRoot
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />
      <div className='w-full flex items-center py-4 gap-2'>
        <Link href='/dashboard/products/create'>
          <Plus className='bg-green-500 p-1 rounded-sm text-white hover:bg-green-400 transition-all duration-150' />
        </Link>
      </div>
      <div className='mt-7'>
        <h1>Lista de Produtos</h1>
        <div className='flex flex-col gap-2 mt-7'>
          <div className='relative overflow-x-auto shadow-md sm:rounded-lg'>
            <TableRoot
              key='id'
              data={content}
              columns={[
                {
                  heading: 'Código',
                  element(row) {
                    return <>{row.id}</>;
                  }
                },
                {
                  heading: 'SKU',
                  element(row) {
                    return <>{row.sku}</>;
                  }
                },
                {
                  heading: 'Nome',
                  element(row) {
                    return <>{row.name}</>;
                  }
                },
                {
                  heading: 'Price',
                  element(row) {
                    return <>{FORMAR_PRICE_V1(row.price || 0.0)}</>;
                  }
                },
                {
                  heading: 'Ações',
                  element(row) {
                    return (
                      <TableActions
                        entity='products'
                        id={row.id}
                        onDelete={handleDelete}
                      />
                    );
                  }
                }
              ]}
            />
          </div>
        </div>
      </div>
    </div>
  );
}
