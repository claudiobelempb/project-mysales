'use client';

import { HeaderRoot } from '@/components/HeaderRoot';
import { LoadingRoot, LoadingSvg } from '@/components/LoadingRoot';
import { TableActions, TableRoot } from '@/components/TableRoot';
import { ClientDTO } from '@/http/response/ClientDTO';
import { ClientDeleteService } from '@/services/client/ClientDelete.service';
import { ClientFindAllService } from '@/services/client/ClientFindAll.service';
import { Plus } from 'lucide-react';
import Link from 'next/link';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

export default function Users() {
  const [content, setContent] = useState<ClientDTO[]>([]);
  const [loading, setLoading] = useState(true);

  const handleDelete = async (id: number) => {
    try {
      await ClientDeleteService(id);

      toast.success('Cliente deletado com sucesso!');
      const list: ClientDTO[] = content.filter(p => p.id !== id);
      setContent(list);
    } catch (error) {
      console.log(JSON.parse(JSON.stringify(error)));
    }
  };

  useEffect(() => {
    (async function loadingProduct() {
      try {
        const response = await ClientFindAllService();
        console.log(response);
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
    <main
      className={`
      h-screen
      
    `}
    >
      <HeaderRoot
        title='Página Clientes'
        subTitle='Aqui voçê irá gerenciar seus Clientes!'
      />
      <div className='w-full flex items-center py-4 gap-2'>
        <Link href='/dashboard/clients/create'>
          <Plus className='bg-green-500 p-1 rounded-sm text-white hover:bg-green-400 transition-all duration-150' />
        </Link>
      </div>
      <div className='mt-7'>
        <h1>Clientes</h1>
        <div className='flex flex-col gap-2 mt-7'>
          <div className='relative overflow-x-auto shadow-md sm:rounded-lg'>
            <TableRoot
              key={'id'}
              data={content}
              columns={[
                {
                  heading: 'ID',
                  element(row) {
                    return <>{row.id}</>;
                  }
                },
                {
                  heading: 'Name',
                  element(row) {
                    return <>{row.name}</>;
                  }
                },
                {
                  heading: 'CPF',
                  element(row) {
                    return <>{row.cpf}</>;
                  }
                },
                {
                  heading: 'Email',
                  element(row) {
                    return <>{row.email}</>;
                  }
                },
                {
                  heading: 'Telefone',
                  element(row) {
                    return <>{row.teleohone}</>;
                  }
                },
                {
                  heading: 'Ações',
                  element(row) {
                    return (
                      <TableActions
                        entity='clients'
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
    </main>
  );
}
