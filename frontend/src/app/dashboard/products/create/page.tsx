'use client';

import { AlertRoot } from '@/components/AlertRoot';
import { ButtonRoot, ButtonText } from '@/components/ButtonRoot';
import { Header } from '@/components/header';
import {
  InputDefault,
  InputLabel,
  InputRoot,
  InputTextArea
} from '@/components/InputRoot';
import { ProductCreateService } from '@/services/product/ProductCreateService';
import { ConstantValidationError } from '@/utils/constant/ConstantValidError';
import { formatDate } from '@/utils/format/date';
import { formatBigDecimal } from '@/utils/format/money';
import { maskReal } from '@/utils/mask/money';
import { ChevronLeft } from 'lucide-react';
import Link from 'next/link';
import { useState } from 'react';
import { toast } from 'react-toastify';
import * as yup from 'yup';

type fieldsProps = {
  id?: number;
  sku: string;
  name: string;
  price: number | string;
  description: string;
};

type errorsProps = {
  sku?: string;
  name?: string;
  price?: string;
  description?: string;
};

const validSchema = yup.object().shape({
  sku: yup.string().trim().required(ConstantValidationError.required),
  price: yup
    .number()
    .required(ConstantValidationError.required)
    .moreThan(0, ConstantValidationError.moreThan),
  name: yup.string().trim().required(ConstantValidationError.required),
  description: yup
    .string()
    .trim()
    .min(10, ConstantValidationError.min(10))
    .required(ConstantValidationError.required)
});

type ValidProductType = yup.InferType<typeof validSchema>;

export default function Products() {
  const [sku, setSku] = useState('');
  const [price, setPrice] = useState('00,00');
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [id, setId] = useState('');
  const [createdAt, SetCreatedAt] = useState('');
  const [errors, setErrors] = useState<errorsProps>({} as errorsProps);

  const handleSubmit = async () => {
    try {
      const product: fieldsProps = {
        id: parseInt(id),
        sku,
        price: formatBigDecimal(price),
        name,
        description
      };

      const p = await validSchema.validate(product);

      console.log('Products =>', p);

      const response = await ProductCreateService(p);

      setId(String(response.id) ?? '');
      SetCreatedAt(response.createdAt ?? '');
      toast.success('Produto cadastrao com sucesso!');

      setErrors({});
    } catch (error) {
      if (error instanceof yup.ValidationError) {
        const field = error.path;
        const message = error.message;

        setErrors({
          [`${field}`]: message
        });

        console.log(JSON.parse(JSON.stringify(error)));
      }
    }
  };

  return (
    <>
      <Header
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />

      <div className='w-full flex items-center py-4 '>
        <Link
          className='bg-gray-500 p-1 rounded-sm text-white'
          href='/dashboard/products'
        >
          <ChevronLeft />
        </Link>
      </div>
      <div className='mt-7'>
        <h1>Cadastro de Produto</h1>
        <div className='flex flex-col gap-2 mt-7'>
          {id && (
            <div className='flex gap-2'>
              <InputRoot className='w-full'>
                <InputLabel>Código: *</InputLabel>
                <InputDefault
                  className='bg-gray-400 font-semibold'
                  disabled
                  type='text'
                  value={id}
                />
              </InputRoot>
              <InputRoot className='w-full'>
                <InputLabel>Data cadastro: *</InputLabel>
                <InputDefault
                  className='bg-gray-400 font-semibold'
                  disabled
                  type='text'
                  value={formatDate(createdAt)}
                />
              </InputRoot>
            </div>
          )}
          <div className='flex flex-col gap-2 lg:flex-row'>
            <InputRoot className='w-full'>
              <InputLabel>SKU: *</InputLabel>
              <InputDefault
                placeholder='Digite o SKU do produto'
                type='text'
                value={sku}
                onChange={e => setSku(e.target.value)}
              />
              {errors.sku && (
                <AlertRoot
                  className='text-red-500'
                  message={errors.sku}
                  type='default'
                />
              )}
            </InputRoot>

            <InputRoot className='w-full'>
              <InputLabel>Preço: *</InputLabel>
              <InputDefault
                placeholder='Digite o Preço do produto'
                type='text'
                value={maskReal(price)}
                onChange={e => setPrice(maskReal(e.target.value))}
                maxLength={16}
              />
              {errors.price && (
                <AlertRoot
                  className='text-red-500'
                  message={`${errors.price}`}
                  type='default'
                />
              )}
            </InputRoot>
          </div>
          <InputRoot>
            <InputLabel>Nome: *</InputLabel>
            <InputDefault
              placeholder='Digite o Nome do produto'
              type='text'
              value={name}
              onChange={e => setName(e.target.value)}
            />
            {errors.name && (
              <AlertRoot
                className='text-red-500'
                message={errors.name}
                type='default'
              />
            )}
          </InputRoot>

          <InputRoot>
            <InputLabel>Descrição: *</InputLabel>
            <InputTextArea
              cols={10}
              rows={6}
              placeholder='Digite a Descrição detalhada do produto'
              className={`resize-none ${
                yup.BooleanSchema
                  ? 'border border-red-500'
                  : 'border border-green-500'
              }`}
              value={description}
              onChange={e => setDescription(e.target.value)}
            />
            {errors.description && (
              <AlertRoot
                className='text-red-500'
                message={errors.description}
                type='default'
              />
            )}
          </InputRoot>
          <ButtonRoot
            onClick={handleSubmit}
            className='bg-white hover:bg-black'
          >
            <ButtonText className='text-black group-hover:text-white'>
              Salvar
            </ButtonText>
          </ButtonRoot>
        </div>
      </div>
    </>
  );
}
